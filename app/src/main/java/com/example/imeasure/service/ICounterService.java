package com.example.imeasure.service;
public interface ICounterService extends android.os.IInterface
{
  /** Default implementation for ICounterService. */
  public static class Default implements ICounterService
  {
    // Returns the name of the components that are being logged.

    @Override public String[] getComponents() throws android.os.RemoteException
    {
      return null;
    }
    // Returns the maximum power usage for each of the components being logged.

    @Override public int[] getComponentsMaxPower() throws android.os.RemoteException
    {
      return null;
    }
    // Returns a bit mask with a 1 in the ith bit if component i doesn't have
    // uid specific information.

    @Override public int getNoUidMask() throws android.os.RemoteException
    {
      return 0;
    }
    // Returns the power consumption in mW for component componentId for the last
    // count iterations.  uid can be specified to make this data only include a
    // specific user id or you can provide SystemInfo.AID_ALL to request
    // global power state information.

    @Override public int[] getComponentHistory(int count, int componentId, int uid) throws android.os.RemoteException
    {
      return null;
    }
    // Returns the total energy consumption for each component in the same order
    // that the components were returned in getComponents() and in the same order
    // that the components are populated by PhoneSelector.generateComponents().
    //
    // uid can be specified to make the information specific to a single user
    // id or SystemInfo.AID_ALL can be specified to request global information.
    //
    // windowType should be one of Counter.WINDOW_MINUTE, Counter.WINDOW_HOUR,
    // Counter.WINDOW_DAY, Counter.WINDOW_TOTAL to request the window that the
    // energy usage will be calculated over.
    //
    // The returned result is given in mJ.

    @Override public long[] getTotals(int uid, int windowType) throws android.os.RemoteException
    {
      return null;
    }
    // Like getTotals() except that each entry is divided by how long the given
    // uid was running.  If SystemInfo.AID_ALL is provided this is effectively
    // like dividing each entry by the window size. (unless PowerTutor hasn't
    // been running that long).

    @Override public long[] getMeans(int uid, int windowType) throws android.os.RemoteException
    {
      return null;
    }
    // Gets the total time that this uid has been running in seconds.

    @Override public long getRuntime(int uid, int windowType) throws android.os.RemoteException
    {
      return 0L;
    }
    // Returns a byte array representing a serialized array of UidInfo structures.
    // See UidInfo.java for what information is given.  Note that members marked
    // as transient are not filled in.
    // Power contributions from component i will be dropped if the ith bit is set
    // in ignoreMask.  Providing 0 for ignoreMask will give results for all
    // components.
    //
    // Example Usage:
    //   byte[] rawUidInfo = counterService.getUidInfo(windowType);
    //   UidInfo[] uidInfos = (UidInfo[])new ObjectInputStream(
    //       new ByteArrayInputStream(rawUidInfo)).readObject();

    @Override public byte[] getUidInfo(int windowType, int ignoreMask) throws android.os.RemoteException
    {
      return null;
    }
    // Return miscellaneous data point for the passed uid.
    // Current extras included:
    //   OLEDSCORE

    @Override public long getUidExtra(String name, int uid) throws android.os.RemoteException
    {
      return 0L;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements ICounterService
  {
    private static final String DESCRIPTOR = "com.example.imeasure.service.ICounterService";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an edu.umich.PowerTutor.service.ICounterService interface,
     * generating a proxy if needed.
     */
    public static ICounterService asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof ICounterService))) {
        return ((ICounterService)iin);
      }
      return new com.example.imeasure.service.ICounterService.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_getComponents:
        {
          data.enforceInterface(descriptor);
          String[] _result = this.getComponents();
          reply.writeNoException();
          reply.writeStringArray(_result);
          return true;
        }
        case TRANSACTION_getComponentsMaxPower:
        {
          data.enforceInterface(descriptor);
          int[] _result = this.getComponentsMaxPower();
          reply.writeNoException();
          reply.writeIntArray(_result);
          return true;
        }
        case TRANSACTION_getNoUidMask:
        {
          data.enforceInterface(descriptor);
          int _result = this.getNoUidMask();
          reply.writeNoException();
          reply.writeInt(_result);
          return true;
        }
        case TRANSACTION_getComponentHistory:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          int _arg2;
          _arg2 = data.readInt();
          int[] _result = this.getComponentHistory(_arg0, _arg1, _arg2);
          reply.writeNoException();
          reply.writeIntArray(_result);
          return true;
        }
        case TRANSACTION_getTotals:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          long[] _result = this.getTotals(_arg0, _arg1);
          reply.writeNoException();
          reply.writeLongArray(_result);
          return true;
        }
        case TRANSACTION_getMeans:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          long[] _result = this.getMeans(_arg0, _arg1);
          reply.writeNoException();
          reply.writeLongArray(_result);
          return true;
        }
        case TRANSACTION_getRuntime:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          long _result = this.getRuntime(_arg0, _arg1);
          reply.writeNoException();
          reply.writeLong(_result);
          return true;
        }
        case TRANSACTION_getUidInfo:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          byte[] _result = this.getUidInfo(_arg0, _arg1);
          reply.writeNoException();
          reply.writeByteArray(_result);
          return true;
        }
        case TRANSACTION_getUidExtra:
        {
          data.enforceInterface(descriptor);
          String _arg0;
          _arg0 = data.readString();
          int _arg1;
          _arg1 = data.readInt();
          long _result = this.getUidExtra(_arg0, _arg1);
          reply.writeNoException();
          reply.writeLong(_result);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements ICounterService
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      // Returns the name of the components that are being logged.

      @Override public String[] getComponents() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        String[] _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getComponents, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getComponents();
          }
          _reply.readException();
          _result = _reply.createStringArray();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      // Returns the maximum power usage for each of the components being logged.

      @Override public int[] getComponentsMaxPower() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int[] _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getComponentsMaxPower, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getComponentsMaxPower();
          }
          _reply.readException();
          _result = _reply.createIntArray();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      // Returns a bit mask with a 1 in the ith bit if component i doesn't have
      // uid specific information.

      @Override public int getNoUidMask() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getNoUidMask, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getNoUidMask();
          }
          _reply.readException();
          _result = _reply.readInt();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      // Returns the power consumption in mW for component componentId for the last
      // count iterations.  uid can be specified to make this data only include a
      // specific user id or you can provide SystemInfo.AID_ALL to request
      // global power state information.

      @Override public int[] getComponentHistory(int count, int componentId, int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int[] _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(count);
          _data.writeInt(componentId);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getComponentHistory, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getComponentHistory(count, componentId, uid);
          }
          _reply.readException();
          _result = _reply.createIntArray();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      // Returns the total energy consumption for each component in the same order
      // that the components were returned in getComponents() and in the same order
      // that the components are populated by PhoneSelector.generateComponents().
      //
      // uid can be specified to make the information specific to a single user
      // id or SystemInfo.AID_ALL can be specified to request global information.
      //
      // windowType should be one of Counter.WINDOW_MINUTE, Counter.WINDOW_HOUR,
      // Counter.WINDOW_DAY, Counter.WINDOW_TOTAL to request the window that the
      // energy usage will be calculated over.
      //
      // The returned result is given in mJ.

      @Override public long[] getTotals(int uid, int windowType) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        long[] _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          _data.writeInt(windowType);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getTotals, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getTotals(uid, windowType);
          }
          _reply.readException();
          _result = _reply.createLongArray();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      // Like getTotals() except that each entry is divided by how long the given
      // uid was running.  If SystemInfo.AID_ALL is provided this is effectively
      // like dividing each entry by the window size. (unless PowerTutor hasn't
      // been running that long).

      @Override public long[] getMeans(int uid, int windowType) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        long[] _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          _data.writeInt(windowType);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getMeans, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getMeans(uid, windowType);
          }
          _reply.readException();
          _result = _reply.createLongArray();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      // Gets the total time that this uid has been running in seconds.

      @Override public long getRuntime(int uid, int windowType) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        long _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          _data.writeInt(windowType);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getRuntime, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getRuntime(uid, windowType);
          }
          _reply.readException();
          _result = _reply.readLong();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      // Returns a byte array representing a serialized array of UidInfo structures.
      // See UidInfo.java for what information is given.  Note that members marked
      // as transient are not filled in.
      // Power contributions from component i will be dropped if the ith bit is set
      // in ignoreMask.  Providing 0 for ignoreMask will give results for all
      // components.
      //
      // Example Usage:
      //   byte[] rawUidInfo = counterService.getUidInfo(windowType);
      //   UidInfo[] uidInfos = (UidInfo[])new ObjectInputStream(
      //       new ByteArrayInputStream(rawUidInfo)).readObject();

      @Override public byte[] getUidInfo(int windowType, int ignoreMask) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        byte[] _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(windowType);
          _data.writeInt(ignoreMask);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getUidInfo, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getUidInfo(windowType, ignoreMask);
          }
          _reply.readException();
          _result = _reply.createByteArray();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      // Return miscellaneous data point for the passed uid.
      // Current extras included:
      //   OLEDSCORE

      @Override public long getUidExtra(String name, int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        long _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(name);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getUidExtra, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getUidExtra(name, uid);
          }
          _reply.readException();
          _result = _reply.readLong();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static ICounterService sDefaultImpl;
    }
    static final int TRANSACTION_getComponents = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_getComponentsMaxPower = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_getNoUidMask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_getComponentHistory = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_getTotals = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    static final int TRANSACTION_getMeans = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
    static final int TRANSACTION_getRuntime = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
    static final int TRANSACTION_getUidInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
    static final int TRANSACTION_getUidExtra = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
    public static boolean setDefaultImpl(ICounterService impl) {
      // Only one user of this interface can use this function
      // at a time. This is a heuristic to detect if two different
      // users in the same process use this function.
      if (Proxy.sDefaultImpl != null) {
        throw new IllegalStateException("setDefaultImpl() called twice");
      }
      if (impl != null) {
        Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static ICounterService getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
  }
  // Returns the name of the components that are being logged.

  public String[] getComponents() throws android.os.RemoteException;
  // Returns the maximum power usage for each of the components being logged.

  public int[] getComponentsMaxPower() throws android.os.RemoteException;
  // Returns a bit mask with a 1 in the ith bit if component i doesn't have
  // uid specific information.

  public int getNoUidMask() throws android.os.RemoteException;
  // Returns the power consumption in mW for component componentId for the last
  // count iterations.  uid can be specified to make this data only include a
  // specific user id or you can provide SystemInfo.AID_ALL to request
  // global power state information.

  public int[] getComponentHistory(int count, int componentId, int uid) throws android.os.RemoteException;
  // Returns the total energy consumption for each component in the same order
  // that the components were returned in getComponents() and in the same order
  // that the components are populated by PhoneSelector.generateComponents().
  //
  // uid can be specified to make the information specific to a single user
  // id or SystemInfo.AID_ALL can be specified to request global information.
  //
  // windowType should be one of Counter.WINDOW_MINUTE, Counter.WINDOW_HOUR,
  // Counter.WINDOW_DAY, Counter.WINDOW_TOTAL to request the window that the
  // energy usage will be calculated over.
  //
  // The returned result is given in mJ.

  public long[] getTotals(int uid, int windowType) throws android.os.RemoteException;
  // Like getTotals() except that each entry is divided by how long the given
  // uid was running.  If SystemInfo.AID_ALL is provided this is effectively
  // like dividing each entry by the window size. (unless PowerTutor hasn't
  // been running that long).

  public long[] getMeans(int uid, int windowType) throws android.os.RemoteException;
  // Gets the total time that this uid has been running in seconds.

  public long getRuntime(int uid, int windowType) throws android.os.RemoteException;
  // Returns a byte array representing a serialized array of UidInfo structures.
  // See UidInfo.java for what information is given.  Note that members marked
  // as transient are not filled in.
  // Power contributions from component i will be dropped if the ith bit is set
  // in ignoreMask.  Providing 0 for ignoreMask will give results for all
  // components.
  //
  // Example Usage:
  //   byte[] rawUidInfo = counterService.getUidInfo(windowType);
  //   UidInfo[] uidInfos = (UidInfo[])new ObjectInputStream(
  //       new ByteArrayInputStream(rawUidInfo)).readObject();

  public byte[] getUidInfo(int windowType, int ignoreMask) throws android.os.RemoteException;
  // Return miscellaneous data point for the passed uid.
  // Current extras included:
  //   OLEDSCORE

  public long getUidExtra(String name, int uid) throws android.os.RemoteException;
}
