package com.example.scanner;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ScannerTest {

    @Test
    public void testBarcode12345(){
        Barcode barcode = Barcode.valueOf("12345");
        Assert.assertEquals("$7.25", Scanner.scan(barcode));
    }

    @Test
    public void testBarcode23456(){
        Barcode barcode = Barcode.valueOf("23456");
        Assert.assertEquals("$12.50", Scanner.scan(barcode));
    }

    @Test
    public void testBarcode99999(){
        Barcode barcode = Barcode.valueOf("99999");
        Assert.assertEquals("Error: barcode not found", Scanner.scan(barcode));
    }

    @Test
    public void testEmptyBarcode(){
        Barcode barcode = Barcode.valueOf("");
        Assert.assertEquals("Error: empty barcode", Scanner.scan(barcode));
    }

    @Test
    public void testTotalBarcodeScan(){
        List<Barcode> barcodes = new ArrayList<>();
        barcodes.add(Barcode.valueOf("12345"));
        barcodes.add(Barcode.valueOf("23456"));
        Assert.assertEquals("$19.75", Scanner.total(barcodes));
    }

    @Test
    public void testTotalBarcodeScanWithExceptionalCases(){
        List<Barcode> barcodes = new ArrayList<>();
        barcodes.add(Barcode.valueOf("12345"));
        barcodes.add(Barcode.valueOf("23456"));
        barcodes.add(Barcode.valueOf("99999"));
        barcodes.add(Barcode.empty());
        Assert.assertEquals("$19.75", Scanner.total(barcodes));
    }
}