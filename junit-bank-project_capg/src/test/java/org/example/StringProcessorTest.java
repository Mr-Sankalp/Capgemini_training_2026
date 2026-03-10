package org.example;

import junit.framework.TestCase;

public class StringProcessorTest extends TestCase {

    private StringProcessor processor;

    protected void setUp() {
        processor = new StringProcessor();
    }

    // Test successful concatenation
    public void testConcatenateSuccess() {
        String result = processor.concatenate("Hello", "World");
        assertEquals("HelloWorld", result);
    }

    // Test concatenate with null input
    public void testConcatenateNull() {
        try {
            processor.concatenate(null, "World");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Strings cannot be null", e.getMessage());
        }
    }

    // Test palindrome true
    public void testIsPalindromeTrue() {
        assertTrue(processor.isPalindrome("madam"));
    }

    // Test palindrome false
    public void testIsPalindromeFalse() {
        assertFalse(processor.isPalindrome("hello"));
    }

    // Test palindrome null
    public void testIsPalindromeNull() {
        assertFalse(processor.isPalindrome(null));
    }
}