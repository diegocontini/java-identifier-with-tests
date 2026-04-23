package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IdentifierTest {
    private static Identifier identifier;
    private static String td;

    @BeforeAll
    static void setUp() {
        identifier = new Identifier();
        td = "";
    }

    @Test
    void validatesIdentifiersThatStartWithLetterAndContainOnlyLettersOrDigits() {
        td = "a";
        assertTrue(identifier.validateIdentifier(td));

        td = "Ab12";
        assertTrue(identifier.validateIdentifier(td));

        td = "abc12";
        assertTrue(identifier.validateIdentifier(td));
    }

    @Test
    void rejectsIdentifiersThatDoNotStartWithLetter() {
        td = "1abc";
        assertFalse(identifier.validateIdentifier(td));

        td = "_abc";
        assertFalse(identifier.validateIdentifier(td));
    }

    @Test
    void rejectsIdentifiersWithNonAlphanumericCharactersAfterFirstCharacter() {
        td = "a_b";
        assertFalse(identifier.validateIdentifier(td));

        td = "ab#";
        assertFalse(identifier.validateIdentifier(td));
    }

    @Test
    void rejectsIdentifiersLongerThanSixCharacters() {
        td = "abc1234";
        assertFalse(identifier.validateIdentifier(td));
    }

    @Test
    void rejectsEmptyIdentifier() {
        td = "";
        assertFalse(identifier.validateIdentifier(td));
    }

    @Test
    void validSReturnsTrueOnlyForLetters() {
        td = "A";
        assertTrue(identifier.valid_s(td.charAt(0)));

        td = "z";
        assertTrue(identifier.valid_s(td.charAt(0)));

        td = "0";
        assertFalse(identifier.valid_s(td.charAt(0)));

        td = "_";
        assertFalse(identifier.valid_s(td.charAt(0)));
    }

    @Test
    void validFReturnsTrueOnlyForLettersAndDigits() {
        td = "A";
        assertTrue(identifier.valid_f(td.charAt(0)));

        td = "z";
        assertTrue(identifier.valid_f(td.charAt(0)));

        td = "0";
        assertTrue(identifier.valid_f(td.charAt(0)));

        td = "9";
        assertTrue(identifier.valid_f(td.charAt(0)));

        td = "_";
        assertFalse(identifier.valid_f(td.charAt(0)));
    }
}
