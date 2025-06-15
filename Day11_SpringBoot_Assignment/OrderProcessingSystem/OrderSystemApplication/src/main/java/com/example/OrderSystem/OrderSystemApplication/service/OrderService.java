package com.example.OrderSystem.OrderSystemApplication.service;

import com.example.OrderSystem.OrderSystemApplication.exception.InvalidOrderStateException;
import com.example.OrderSystem.OrderSystemApplication.model.Order;
import com.example.OrderSystem.OrderSystemApplication.model.OrderEvent;
import com.example.OrderSystem.OrderSystemApplication.model.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService implements Runnable {

    @Autowired
    private StateMachine<OrderState, OrderEvent> stateMachine;

    private AtomicLong idGenerator = new AtomicLong(1);
    private Random random = new Random();

    @Override
    public void run() {
        while (true) {
            try {
                Order order = new Order(idGenerator.getAndIncrement(), "Order Description");
                System.out.println("Created: " + order.getId() + " | State: " + order.getState());

                OrderEvent[] events = OrderEvent.values();
                for (int i = 0; i < 4; i++) {
                    OrderEvent event = events[random.nextInt(events.length)];

                    if (canTransition(order.getState(), event)) {
                        stateMachine.start();
                        stateMachine.getStateMachineAccessor().doWithAllRegions(access -> {
                            access.resetStateMachine(org.springframework.statemachine.state.StateMachineContext.of(order.getState(), null));
                        });
                        stateMachine.sendEvent(event);
                        order.setState(stateMachine.getState().getId());
                        System.out.println("Order " + order.getId() + " transitioned to " + order.getState());
                    } else {
                        throw new InvalidOrderStateException("Invalid transition from " + order.getState() + " with event " + event);
                    }
                }

                Thread.sleep(2000);
            } catch (InvalidOrderStateException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean canTransition(OrderState state, OrderEvent event) {
        return switch (state) {
            case NEW -> event == OrderEvent.PROCESS;
            case PROCESSING -> event == OrderEvent.SHIP;
            case SHIPPED -> event == OrderEvent.DELIVER;
            case DELIVERED -> event == OrderEvent.CANCEL;
            default -> false;
        };
    }
}