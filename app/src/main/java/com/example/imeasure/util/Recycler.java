package com.example.imeasure.util;

import java.util.Vector;
public class Recycler<T> {
  private Vector<T> list;
  private int avail;

  public Recycler() {
    list = new Vector<T>();
    avail = 0;
  }

  public synchronized T obtain() {
    if(avail == 0) {
      return null;
    }
    return list.get(--avail);
  }

  public synchronized void recycle(T a) {
    if(avail < list.size()) {
      list.set(avail++, a);
    } else {
      list.add(a);
    }
  }
}
