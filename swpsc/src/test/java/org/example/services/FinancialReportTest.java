package org.example.services;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FinancialReportTest {

    @Test
    void testRecordAndPrintReport() {
        FinancialReport.record(15.0);
        FinancialReport.record(20.0);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        FinancialReport.printReport();

        String printed = out.toString();
        assertTrue(printed.contains("Total Orders"));
        assertTrue(printed.contains("Total Revenue"));
    }
}