package com.rifas.trevorifas.common.util;

public class FormatNumber {

  public static String  addZeroLeft(int numero) {
    return (numero < 10) ? "0" + numero : String.valueOf(numero);
  }


}
