package com.scalefocus.tibco.camel.training.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author Angel Zlatenov
 */

public class JMSException extends Exception{

    private final String at = "\tat ";

    public JMSException(String message) {
        super(message);
    }

    public JMSException(String message, Throwable cause) {
        super(message, cause);
    }

    public JMSException(Throwable cause) {
        super(cause);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        s.print(this);
        Arrays.asList(getStackTrace()).forEach(traceElement -> s.print(at + traceElement));
        if (getCause() != null) {
            Arrays.asList(getCause().getStackTrace()).forEach(traceElement -> s.print(at + traceElement));
        }
    }

    @Override
    public void printStackTrace(PrintStream s) {
        s.print(this);
        Arrays.asList(getStackTrace()).forEach(traceElement -> s.print(at + traceElement));
        if (getCause() != null) {
            Arrays.asList(getCause().getStackTrace()).forEach(traceElement -> s.print(at + traceElement));
        }
    }
}
