package com.silo.backend.command.infrastructure.service;

import org.springframework.stereotype.Component;

@Component
public class BusinessRuleValidator {

    public void assertArgumentEquals(Object anObject1, Object anObject2, String aMessage) {
        if (!anObject1.equals(anObject2)) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public void assertArgumentFalse(boolean aBoolean, String aMessage) {
        if (aBoolean) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public void assertArgumentLength(String aString, int aMaximum, String aMessage) {
        int length = aString.trim().length();
        if (length > aMaximum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public void assertArgumentLength(String aString, int aMinimum, int aMaximum, String aMessage) {
        int length = aString.trim().length();
        if (length < aMinimum || length > aMaximum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public void assertArgumentNotEmpty(String aString, String aMessage) {
        if (aString == null || aString.trim().isEmpty()) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public void assertArgumentNotEquals(Object anObject1, Object anObject2, String aMessage) {
        if (anObject1.equals(anObject2)) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public void assertArgumentNotNull(Object anObject, String aMessage) {
        if (anObject == null) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public void assertArgumentRange(double aValue, double aMinimum, double aMaximum, String aMessage) {
        if (aValue < aMinimum || aValue > aMaximum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public void assertArgumentRange(float aValue, float aMinimum, float aMaximum, String aMessage) {
        if (aValue < aMinimum || aValue > aMaximum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public void assertArgumentRange(int aValue, int aMinimum, int aMaximum, String aMessage) {
        if (aValue < aMinimum || aValue > aMaximum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public void assertArgumentRange(long aValue, long aMinimum, long aMaximum, String aMessage) {
        if (aValue < aMinimum || aValue > aMaximum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public void assertArgumentTrue(boolean aBoolean, String aMessage) {
        if (!aBoolean) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    public void assertStateFalse(boolean aBoolean, String aMessage) {
        if (aBoolean) {
            throw new IllegalStateException(aMessage);
        }
    }

    public void assertStateTrue(boolean aBoolean, String aMessage) {
        if (!aBoolean) {
            throw new IllegalStateException(aMessage);
        }
    }
}