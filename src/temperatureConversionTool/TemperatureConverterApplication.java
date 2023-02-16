package temperatureConversionTool;

import javax.swing.*;

public class TemperatureConverterApplication {
    public static void main(String[] args) {
        TemperatureConverterApplication temperatureConverter = new TemperatureConverterApplication();
        temperatureConverter.run();
    }

    private void run() {
        String[] temperatureTypes = {"Fahrenheit", "Celsius", "Kelvin"};
        String fromUnit = (String) JOptionPane.showInputDialog(null, "Enter the unit you want to convert from:",
                "Temperature Converter", JOptionPane.PLAIN_MESSAGE, null, temperatureTypes, temperatureTypes[0]);
        double fromValue = temperatureInput("Enter the temperature value to convert from " + fromUnit + ":");
        String toUnit = (String)JOptionPane.showInputDialog(null, "Select the unit you want to convert to:",
                "Temperature Converter", JOptionPane.PLAIN_MESSAGE, null, temperatureTypes, temperatureTypes[0]);
        double toValue = convertTemperature(fromValue, fromUnit, toUnit);
        display(fromValue, fromUnit, toValue, toUnit);
    }

    private void display(double fromValue, String fromUnit, double toValue, String toUnit) {
        JOptionPane.showMessageDialog(null, fromValue + " " + fromUnit + " = " + toValue + " " + toUnit, "Temperature Converter", JOptionPane.INFORMATION_MESSAGE);
    }

    private double convertTemperature(double value, String fromUnit, String toUnit) {
        if (fromUnit.equalsIgnoreCase("Celsius")) {
            if (toUnit.equalsIgnoreCase("Fahrenheit")) {
                return (value * 9/5) + 32;
            } else if (toUnit.equalsIgnoreCase("Kelvin")) {
                return value + 273.15;
            }
        } else if (fromUnit.equalsIgnoreCase("Fahrenheit")) {
            if (toUnit.equalsIgnoreCase("Celsius")) {
                return (value - 32) * 5/9;
            } else if (toUnit.equalsIgnoreCase("Kelvin")) {
                return (value + 459.67) * 5 / 9;
            }
        } else if (fromUnit.equalsIgnoreCase("Kelvin")) {
            if (toUnit.equalsIgnoreCase("Celsius")) {
                return value - 273.15;
            } else if (toUnit.equalsIgnoreCase("Fahrenheit")) {
                return (value * 9/5) - 459.67;
            }
        }
        return value;
    }

    private double temperatureInput(String text) {
        String input = JOptionPane.showInputDialog(text);
        return Double.parseDouble(input);
    }
}
