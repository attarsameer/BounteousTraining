package com.example.OrderSystem.OrderSystemApplication.config;

import com.example.OrderSystem.OrderSystemApplication.model.OrderEvent;
import com.example.OrderSystem.OrderSystemApplication.model.OrderState;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderState, OrderEvent> {

    @Override
    public void configure(StateMachineStateConfigurer<OrderState, OrderEvent> states) throws Exception {
        states.withStates()
                .initial(OrderState.NEW)
                .states(EnumSet.allOf(OrderState.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderState, OrderEvent> transitions) throws Exception {
        transitions
                .withExternal().source(OrderState.NEW).target(OrderState.PROCESSING).event(OrderEvent.PROCESS)
                .and()
                .withExternal().source(OrderState.PROCESSING).target(OrderState.SHIPPED).event(OrderEvent.SHIP)
                .and()
                .withExternal().source(OrderState.SHIPPED).target(OrderState.DELIVERED).event(OrderEvent.DELIVER)
                .and()
                .withExternal().source(OrderState.DELIVERED).target(OrderState.CANCELLED).event(OrderEvent.CANCEL);
    }
}
