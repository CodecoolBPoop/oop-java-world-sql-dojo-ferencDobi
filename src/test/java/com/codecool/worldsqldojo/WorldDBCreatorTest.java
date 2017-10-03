package com.codecool.worldsqldojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldDBCreatorTest {
    @BeforeEach
    void setUp() {
        // TODO: create instance

        // TODO: insert data into db
    }

    @Test
    public void testConnectionBetweenCountryAndCountrylanguage() {
        String query =
                "SELECT\n" +
                    "cl.language, cl.percentage, co.name, co.region\n" +
                "FROM\n" +
                    "countrylanguage cl\n" +
                    "JOIN country co\n" +
                        "ON cl.countrycode = co.code\n" +
                "WHERE\n" +
                    "cl.isofficial IS TRUE;\n";

        // TODO: assertion
    }

    @Test
    public void testConnectionBetweenCountryAndCity() {
        String query =
                "SELECT\n" +
                    "co.name, " +
                        "co.continent, " +
                        "co.region, " +
                        "co.surfacearea, " +
                        "co.governmentform, " +
                        "ci.name as capital_name, " +
                        "ci.population as capital_population\n" +
                "FROM\n" +
                    "country co\n" +
                    "JOIN city ci\n" +
                        "ON co.capital = ci.id";

        // TODO: assertion
    }

    @Test
    public void testOtherRegionThrowsSQLExceptionWithConstraintFailed() {
        String query =
                "INSERT INTO country\n" +
                        "VALUES (\n" +
                        "'ABC',\n" +
                        "'sample name',\n" +
                        "'sample continent',\n" +
                        "'sample region',\n" +
                        "180000.23,\n" +
                        "1900,\n" +
                        "10000000,\n" +
                        "76.6,\n" +
                        "63.20,\n" +
                        "60.20,\n" +
                        "'sample localname',\n" +
                        "'sample govform',\n" +
                        "'sample headofstate',\n" +
                        "1,\n" +
                        "'AB'\n" +
                        ")";

        // TODO: assertion
    }

}