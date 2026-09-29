public class Q2469 {
  public double[] convertTemperature(double celsius) {
    double[] result = new double[2];
    double kelvin = celsius + 273.15;
    double fahrenheit = celsius * 1.80 + 32.00;
    result[0] = kelvin;
    result[1] = fahrenheit;
    return result;
  }
}
