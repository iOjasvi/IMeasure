package com.example.imeasure.util;

public class HexEncode {
  public static String encode(byte[] bytes) {
    StringBuilder bld = new StringBuilder();
    for(int i = 0; i < bytes.length; i++) {
      bld.append((char)('a' + (bytes[i] >> 4 & 0xF)));
      bld.append((char)('a' + (bytes[i] & 0xF)));
    }
    return bld.toString();
  }

  public static byte[] decode(String dat) {
    int N = dat.length() / 2;
    byte[] ret = new byte[N];
    for(int i = 0; i < N; i++) {
      ret[i] = (byte)(dat.charAt(2 * i) - 'a' << 4 |
                      dat.charAt(2 * i + 1) - 'a');
    }
    return ret;
  }
}
