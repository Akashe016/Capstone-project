package com.example.JunitAndMockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import com.example.JunitAndMockito.calculator.CalculatorService;

public class CalculatorServiceTest {

	@Test
    public void testAdd() {
		
		
        CalculatorService calculatorService = mock(CalculatorService.class);
        when(calculatorService.add(4, 3)).thenReturn(7);
        assertEquals(7, calculatorService.add(4, 3));
    }

    @Test
    public void testMultiply() {
    	
    	
        CalculatorService calculatorService = mock(CalculatorService.class);
        when(calculatorService.multiply(4, 3)).thenReturn(12);
        assertEquals(12, calculatorService.multiply(4, 3));
    }

    @Test
    public void testSub() {
    	
    	
        CalculatorService calculatorService = mock(CalculatorService.class);
        when(calculatorService.sub(4, 3)).thenReturn(1);
        assertEquals(1, calculatorService.sub(4, 3));
    }

    @Test
    public void testDivide() {
    	
    	
        CalculatorService calculatorService = mock(CalculatorService.class);
        when(calculatorService.divide(10.0, 2.0)).thenReturn(5.0);
        assertEquals(5.0, calculatorService.divide(10.0, 2.0), 0.0001);
    }
}
