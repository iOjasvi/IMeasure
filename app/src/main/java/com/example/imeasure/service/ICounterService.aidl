package com.example.imeasure.service;

interface ICounterService {

  String[] getComponents();
  int[] getComponentsMaxPower();

  int getNoUidMask();

  int[] getComponentHistory(int count, int componentId, int uid);

  long[] getTotals(int uid, int windowType);

  long[] getMeans(int uid, int windowType);
  long getRuntime(int uid, int windowType);

  byte[] getUidInfo(int windowType, int ignoreMask);
  long getUidExtra(String name, int uid);
}
