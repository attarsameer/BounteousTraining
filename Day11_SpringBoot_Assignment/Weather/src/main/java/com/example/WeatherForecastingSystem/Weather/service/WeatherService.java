package com.example.WeatherForecastingSystem.Weather.service;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.*;

import com.example.WeatherForecastingSystem.Weather.model.WeatherForecast;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final RestTemplate restTemplate = new RestTemplate();

    public Map<LocalDate, WeatherForecast> getForecast(String city, Map<String, double[]> coords) {
        double[] c = coords.get(city);
        if (c == null) throw new IllegalArgumentException("City not found: " + city);

        String url = String.format(
                "https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&daily=temperature_2m_max,temperature_2m_min,wind_speed_10m_max&timezone=auto",
                c[0], c[1]);

        Map<String, Object> resp = restTemplate.getForObject(url, Map.class);
        return parseForecastData(resp);
    }

    private Map<LocalDate, WeatherForecast> parseForecastData(Map<String, Object> json) {
        Map<String, Object> daily = (Map<String, Object>) json.get("daily");
        List<String> dates = (List<String>)   daily.get("time");
        List<Double> temps = (List<Double>)   daily.get("temperature_2m_max");
        List<Double> winds = (List<Double>)  daily.get("wind_speed_10m_max");

        Map<LocalDate, WeatherForecast> map = new LinkedHashMap<>();
        for (int i = 0; i < dates.size(); i++) {
            WeatherForecast w = new WeatherForecast();
            w.setDate(LocalDate.parse(dates.get(i)));
            w.setTemperature(temps.get(i));
            w.setWindSpeed(winds.get(i));
            map.put(w.getDate(), w);
        }
        return map;
    }

    public Map<String, double[]> loadCoordinatesFromExcel(String file) throws Exception {
        Map<String, double[]> m = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(new File(file))) {
            Workbook wb = WorkbookFactory.create(fis);
            for (Row r : wb.getSheetAt(0)) {
                if (r.getRowNum() == 0) continue;
                String city = r.getCell(0).getStringCellValue();
                double lat = r.getCell(1).getNumericCellValue();
                double lon = r.getCell(2).getNumericCellValue();
                m.put(city, new double[]{lat, lon});
            }
        }
        return m;
    }

    public List<String> compareCities(String city1, String city2, Map<String, double[]> coords) {
        Map<LocalDate, WeatherForecast> f1 = getForecast(city1, coords);
        Map<LocalDate, WeatherForecast> f2 = getForecast(city2, coords);

        List<String> out = new ArrayList<>();
        for (LocalDate date : f1.keySet()) {
            WeatherForecast w1 = f1.get(date), w2 = f2.get(date);
            out.add(String.format("Date: %s | %s Max Temp: %.1f | %s Max Temp: %.1f",
                    date, city1, w1.getTemperature(), city2, w2.getTemperature()));
        }
        return out;
    }
}