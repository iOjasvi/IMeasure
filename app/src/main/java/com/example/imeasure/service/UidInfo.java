package com.example.imeasure.service;

import java.io.Serializable;

import com.example.imeasure.util.Recycler;

public class UidInfo implements Serializable, Comparable {
  private static Recycler<UidInfo> recycler = new Recycler<UidInfo>();

  public static UidInfo obtain() {
    UidInfo result = recycler.obtain();
    if(result != null) return result;
    return new UidInfo();
  }

  public void recycle() {
    recycler.recycle(this);
  }

  public int uid;
  public int currentPower;
  public long totalEnergy;
  public long runtime;

  public transient double key;
  public transient double percentage;
  public transient String unit;

  private UidInfo() {
  }

  public void init(int uid, int currentPower, long totalEnergy,
                   long runtime) {
    this.uid = uid;
    this.currentPower = currentPower;
    this.totalEnergy = totalEnergy;
    this.runtime = runtime;
  }

  public int compareTo(Object o) {
    UidInfo x = (UidInfo)o;
    if(key > x.key) return -1;
    if(key == x.key) return 0;
    return 1;
  }
}
