package com.example.scanner;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Scanner {

    private static final Map<Barcode, ScannerResult> mapBarcodeWithResult = new HashMap<>();

    static {
        mapBarcodeWithResult.put(Barcode.valueOf("12345"), new AmountScannerResult(7.25));
        mapBarcodeWithResult.put(Barcode.valueOf("23456"), new AmountScannerResult(12.50));
        mapBarcodeWithResult.put(Barcode.valueOf("99999"), new BarcodeNotFoundScannerResult());
        mapBarcodeWithResult.put(Barcode.empty(), new EmptyBarcodeScannerResult());
    }

    private static ScannerResult retrieveScannerResult(Barcode barcode) {
        if(mapBarcodeWithResult.containsKey(barcode)){
            return mapBarcodeWithResult.get(barcode);
        }
        return null;
    }

    public static String scan(Barcode barcode) {
        ScannerResult scannerResult = retrieveScannerResult(barcode);
        if(scannerResult != null) return scannerResult.toString();
        return null;
    }

    public static String total(List<Barcode> barcodes) {
        return barcodes
                .stream()
                .map(Scanner::retrieveScannerResult)
                .filter(scannerResult -> scannerResult instanceof AmountScannerResult)
                .map (scannerResult -> (AmountScannerResult) scannerResult)
                .reduce(AmountScannerResult::plus)
                .map(AmountScannerResult::toString)
                .orElse(null);
    }

    interface ScannerResult {}

    static class BarcodeNotFoundScannerResult implements ScannerResult {

        @Override
        public String toString() {
            return "Error: barcode not found";
        }
    }
    static class EmptyBarcodeScannerResult implements ScannerResult {

        @Override
        public String toString() {
            return "Error: empty barcode";
        }
    }
    static class AmountScannerResult implements ScannerResult {

        private final double amount;

        AmountScannerResult(double amount){
            this.amount = amount;
        }

        AmountScannerResult plus(AmountScannerResult amountScannerResult){
            return new AmountScannerResult(this.amount + amountScannerResult.amount);
        }

        @Override
        public String toString() {
            return "$" + String.format(Locale.ROOT, "%.2f", amount);
        }
    }
}
