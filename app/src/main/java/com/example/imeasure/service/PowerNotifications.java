package com.example.imeasure.service;
public interface PowerNotifications extends android.os.IInterface
{
  /** Default implementation for PowerNotifications. */
  public static class Default implements PowerNotifications
  {
    // These are the notifications that are actually supported.  The rest have
    // potential to be supported but aren't needed at the moment so aren't
    // actually hooked.

    @Override public void noteStartWakelock(int uid, String name, int type) throws android.os.RemoteException
    {
    }
    @Override public void noteStopWakelock(int uid, String name, int type) throws android.os.RemoteException
    {
    }
    @Override public void noteStartSensor(int uid, int sensor) throws android.os.RemoteException
    {
    }
    @Override public void noteStopSensor(int uid, int sensor) throws android.os.RemoteException
    {
    }
    @Override public void noteStartGps(int uid) throws android.os.RemoteException
    {
    }
    @Override public void noteStopGps(int uid) throws android.os.RemoteException
    {
    }
    @Override public void noteScreenBrightness(int brightness) throws android.os.RemoteException
    {
    }
    @Override public void noteStartMedia(int uid, int id) throws android.os.RemoteException
    {
    }
    @Override public void noteStopMedia(int uid, int id) throws android.os.RemoteException
    {
    }
    @Override public void noteVideoSize(int uid, int id, int width, int height) throws android.os.RemoteException
    {
    }
    @Override public void noteSystemMediaCall(int uid) throws android.os.RemoteException
    {
    }
    @Override public void noteScreenOn() throws android.os.RemoteException
    {
    }
    @Override public void noteScreenOff() throws android.os.RemoteException
    {
    }
    @Override public void noteInputEvent() throws android.os.RemoteException
    {
    }
    @Override public void noteUserActivity(int uid, int event) throws android.os.RemoteException
    {
    }
    @Override public void notePhoneOn() throws android.os.RemoteException
    {
    }
    @Override public void notePhoneOff() throws android.os.RemoteException
    {
    }
    @Override public void notePhoneDataConnectionState(int dataType, boolean hasData) throws android.os.RemoteException
    {
    }
    @Override public void noteWifiOn(int uid) throws android.os.RemoteException
    {
    }
    @Override public void noteWifiOff(int uid) throws android.os.RemoteException
    {
    }
    @Override public void noteWifiRunning() throws android.os.RemoteException
    {
    }
    @Override public void noteWifiStopped() throws android.os.RemoteException
    {
    }
    @Override public void noteBluetoothOn() throws android.os.RemoteException
    {
    }
    @Override public void noteBluetoothOff() throws android.os.RemoteException
    {
    }
    @Override public void noteFullWifiLockAcquired(int uid) throws android.os.RemoteException
    {
    }
    @Override public void noteFullWifiLockReleased(int uid) throws android.os.RemoteException
    {
    }
    @Override public void noteScanWifiLockAcquired(int uid) throws android.os.RemoteException
    {
    }
    @Override public void noteScanWifiLockReleased(int uid) throws android.os.RemoteException
    {
    }
    @Override public void noteWifiMulticastEnabled(int uid) throws android.os.RemoteException
    {
    }
    @Override public void noteWifiMulticastDisabled(int uid) throws android.os.RemoteException
    {
    }
    @Override public void setOnBattery(boolean onBattery, int level) throws android.os.RemoteException
    {
    }
    @Override public void recordCurrentLevel(int level) throws android.os.RemoteException
    {
    }
    /* Also got rid of the non-notification calls.
         * byte[] getStatistics();
         * long getAwakeTimeBattery();
         * long getAwakeTimePlugged();
         *//* Added functions to the normal IBatteryStats interface. */
    @Override public void noteVideoOn(int uid) throws android.os.RemoteException
    {
    }
    @Override public void noteVideoOff(int uid) throws android.os.RemoteException
    {
    }
    @Override public void noteAudioOn(int uid) throws android.os.RemoteException
    {
    }
    @Override public void noteAudioOff(int uid) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements PowerNotifications
  {
    private static final String DESCRIPTOR = "PowerNotifications";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an PowerNotifications interface,
     * generating a proxy if needed.
     */
    public static PowerNotifications asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof PowerNotifications))) {
        return ((PowerNotifications)iin);
      }
      return new PowerNotifications.Stub.Proxy(obj);
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
        case TRANSACTION_noteStartWakelock:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          String _arg1;
          _arg1 = data.readString();
          int _arg2;
          _arg2 = data.readInt();
          this.noteStartWakelock(_arg0, _arg1, _arg2);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteStopWakelock:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          String _arg1;
          _arg1 = data.readString();
          int _arg2;
          _arg2 = data.readInt();
          this.noteStopWakelock(_arg0, _arg1, _arg2);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteStartSensor:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          this.noteStartSensor(_arg0, _arg1);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteStopSensor:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          this.noteStopSensor(_arg0, _arg1);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteStartGps:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteStartGps(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteStopGps:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteStopGps(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteScreenBrightness:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteScreenBrightness(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteStartMedia:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          this.noteStartMedia(_arg0, _arg1);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteStopMedia:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          this.noteStopMedia(_arg0, _arg1);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteVideoSize:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          int _arg2;
          _arg2 = data.readInt();
          int _arg3;
          _arg3 = data.readInt();
          this.noteVideoSize(_arg0, _arg1, _arg2, _arg3);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteSystemMediaCall:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteSystemMediaCall(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteScreenOn:
        {
          data.enforceInterface(descriptor);
          this.noteScreenOn();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteScreenOff:
        {
          data.enforceInterface(descriptor);
          this.noteScreenOff();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteInputEvent:
        {
          data.enforceInterface(descriptor);
          this.noteInputEvent();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteUserActivity:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          this.noteUserActivity(_arg0, _arg1);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_notePhoneOn:
        {
          data.enforceInterface(descriptor);
          this.notePhoneOn();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_notePhoneOff:
        {
          data.enforceInterface(descriptor);
          this.notePhoneOff();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_notePhoneDataConnectionState:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          boolean _arg1;
          _arg1 = (0!=data.readInt());
          this.notePhoneDataConnectionState(_arg0, _arg1);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteWifiOn:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteWifiOn(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteWifiOff:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteWifiOff(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteWifiRunning:
        {
          data.enforceInterface(descriptor);
          this.noteWifiRunning();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteWifiStopped:
        {
          data.enforceInterface(descriptor);
          this.noteWifiStopped();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteBluetoothOn:
        {
          data.enforceInterface(descriptor);
          this.noteBluetoothOn();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteBluetoothOff:
        {
          data.enforceInterface(descriptor);
          this.noteBluetoothOff();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteFullWifiLockAcquired:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteFullWifiLockAcquired(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteFullWifiLockReleased:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteFullWifiLockReleased(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteScanWifiLockAcquired:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteScanWifiLockAcquired(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteScanWifiLockReleased:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteScanWifiLockReleased(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteWifiMulticastEnabled:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteWifiMulticastEnabled(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteWifiMulticastDisabled:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteWifiMulticastDisabled(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_setOnBattery:
        {
          data.enforceInterface(descriptor);
          boolean _arg0;
          _arg0 = (0!=data.readInt());
          int _arg1;
          _arg1 = data.readInt();
          this.setOnBattery(_arg0, _arg1);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_recordCurrentLevel:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.recordCurrentLevel(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteVideoOn:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteVideoOn(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteVideoOff:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteVideoOff(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteAudioOn:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteAudioOn(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_noteAudioOff:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.noteAudioOff(_arg0);
          reply.writeNoException();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements PowerNotifications
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
      // These are the notifications that are actually supported.  The rest have
      // potential to be supported but aren't needed at the moment so aren't
      // actually hooked.

      @Override public void noteStartWakelock(int uid, String name, int type) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          _data.writeString(name);
          _data.writeInt(type);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteStartWakelock, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteStartWakelock(uid, name, type);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteStopWakelock(int uid, String name, int type) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          _data.writeString(name);
          _data.writeInt(type);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteStopWakelock, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteStopWakelock(uid, name, type);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteStartSensor(int uid, int sensor) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          _data.writeInt(sensor);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteStartSensor, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteStartSensor(uid, sensor);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteStopSensor(int uid, int sensor) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          _data.writeInt(sensor);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteStopSensor, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteStopSensor(uid, sensor);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteStartGps(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteStartGps, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteStartGps(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteStopGps(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteStopGps, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteStopGps(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteScreenBrightness(int brightness) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(brightness);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteScreenBrightness, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteScreenBrightness(brightness);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteStartMedia(int uid, int id) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          _data.writeInt(id);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteStartMedia, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteStartMedia(uid, id);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteStopMedia(int uid, int id) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          _data.writeInt(id);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteStopMedia, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteStopMedia(uid, id);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteVideoSize(int uid, int id, int width, int height) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          _data.writeInt(id);
          _data.writeInt(width);
          _data.writeInt(height);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteVideoSize, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteVideoSize(uid, id, width, height);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteSystemMediaCall(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteSystemMediaCall, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteSystemMediaCall(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteScreenOn() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteScreenOn, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteScreenOn();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteScreenOff() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteScreenOff, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteScreenOff();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteInputEvent() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteInputEvent, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteInputEvent();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteUserActivity(int uid, int event) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          _data.writeInt(event);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteUserActivity, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteUserActivity(uid, event);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void notePhoneOn() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_notePhoneOn, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().notePhoneOn();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void notePhoneOff() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_notePhoneOff, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().notePhoneOff();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void notePhoneDataConnectionState(int dataType, boolean hasData) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(dataType);
          _data.writeInt(((hasData)?(1):(0)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_notePhoneDataConnectionState, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().notePhoneDataConnectionState(dataType, hasData);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteWifiOn(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteWifiOn, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteWifiOn(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteWifiOff(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteWifiOff, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteWifiOff(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteWifiRunning() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteWifiRunning, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteWifiRunning();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteWifiStopped() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteWifiStopped, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteWifiStopped();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteBluetoothOn() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteBluetoothOn, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteBluetoothOn();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteBluetoothOff() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteBluetoothOff, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteBluetoothOff();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteFullWifiLockAcquired(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteFullWifiLockAcquired, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteFullWifiLockAcquired(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteFullWifiLockReleased(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteFullWifiLockReleased, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteFullWifiLockReleased(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteScanWifiLockAcquired(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteScanWifiLockAcquired, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteScanWifiLockAcquired(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteScanWifiLockReleased(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteScanWifiLockReleased, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteScanWifiLockReleased(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteWifiMulticastEnabled(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteWifiMulticastEnabled, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteWifiMulticastEnabled(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteWifiMulticastDisabled(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteWifiMulticastDisabled, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteWifiMulticastDisabled(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void setOnBattery(boolean onBattery, int level) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(((onBattery)?(1):(0)));
          _data.writeInt(level);
          boolean _status = mRemote.transact(Stub.TRANSACTION_setOnBattery, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().setOnBattery(onBattery, level);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void recordCurrentLevel(int level) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(level);
          boolean _status = mRemote.transact(Stub.TRANSACTION_recordCurrentLevel, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().recordCurrentLevel(level);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /* Also got rid of the non-notification calls.
           * byte[] getStatistics();
           * long getAwakeTimeBattery();
           * long getAwakeTimePlugged();
           *//* Added functions to the normal IBatteryStats interface. */
      @Override public void noteVideoOn(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteVideoOn, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteVideoOn(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteVideoOff(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteVideoOff, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteVideoOff(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteAudioOn(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteAudioOn, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteAudioOn(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void noteAudioOff(int uid) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(uid);
          boolean _status = mRemote.transact(Stub.TRANSACTION_noteAudioOff, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().noteAudioOff(uid);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      public static PowerNotifications sDefaultImpl;
    }
    static final int TRANSACTION_noteStartWakelock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_noteStopWakelock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_noteStartSensor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_noteStopSensor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_noteStartGps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    static final int TRANSACTION_noteStopGps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
    static final int TRANSACTION_noteScreenBrightness = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
    static final int TRANSACTION_noteStartMedia = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
    static final int TRANSACTION_noteStopMedia = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
    static final int TRANSACTION_noteVideoSize = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
    static final int TRANSACTION_noteSystemMediaCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
    static final int TRANSACTION_noteScreenOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
    static final int TRANSACTION_noteScreenOff = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
    static final int TRANSACTION_noteInputEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
    static final int TRANSACTION_noteUserActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
    static final int TRANSACTION_notePhoneOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
    static final int TRANSACTION_notePhoneOff = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
    static final int TRANSACTION_notePhoneDataConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
    static final int TRANSACTION_noteWifiOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
    static final int TRANSACTION_noteWifiOff = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
    static final int TRANSACTION_noteWifiRunning = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
    static final int TRANSACTION_noteWifiStopped = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
    static final int TRANSACTION_noteBluetoothOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
    static final int TRANSACTION_noteBluetoothOff = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
    static final int TRANSACTION_noteFullWifiLockAcquired = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
    static final int TRANSACTION_noteFullWifiLockReleased = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
    static final int TRANSACTION_noteScanWifiLockAcquired = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
    static final int TRANSACTION_noteScanWifiLockReleased = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
    static final int TRANSACTION_noteWifiMulticastEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
    static final int TRANSACTION_noteWifiMulticastDisabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
    static final int TRANSACTION_setOnBattery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
    static final int TRANSACTION_recordCurrentLevel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
    static final int TRANSACTION_noteVideoOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
    static final int TRANSACTION_noteVideoOff = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
    static final int TRANSACTION_noteAudioOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
    static final int TRANSACTION_noteAudioOff = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
    public static boolean setDefaultImpl(PowerNotifications impl) {
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
    public static PowerNotifications getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
  }
  // These are the notifications that are actually supported.  The rest have
  // potential to be supported but aren't needed at the moment so aren't
  // actually hooked.

  public void noteStartWakelock(int uid, String name, int type) throws android.os.RemoteException;
  public void noteStopWakelock(int uid, String name, int type) throws android.os.RemoteException;
  public void noteStartSensor(int uid, int sensor) throws android.os.RemoteException;
  public void noteStopSensor(int uid, int sensor) throws android.os.RemoteException;
  public void noteStartGps(int uid) throws android.os.RemoteException;
  public void noteStopGps(int uid) throws android.os.RemoteException;
  public void noteScreenBrightness(int brightness) throws android.os.RemoteException;
  public void noteStartMedia(int uid, int id) throws android.os.RemoteException;
  public void noteStopMedia(int uid, int id) throws android.os.RemoteException;
  public void noteVideoSize(int uid, int id, int width, int height) throws android.os.RemoteException;
  public void noteSystemMediaCall(int uid) throws android.os.RemoteException;
  public void noteScreenOn() throws android.os.RemoteException;
  public void noteScreenOff() throws android.os.RemoteException;
  public void noteInputEvent() throws android.os.RemoteException;
  public void noteUserActivity(int uid, int event) throws android.os.RemoteException;
  public void notePhoneOn() throws android.os.RemoteException;
  public void notePhoneOff() throws android.os.RemoteException;
  public void notePhoneDataConnectionState(int dataType, boolean hasData) throws android.os.RemoteException;
  public void noteWifiOn(int uid) throws android.os.RemoteException;
  public void noteWifiOff(int uid) throws android.os.RemoteException;
  public void noteWifiRunning() throws android.os.RemoteException;
  public void noteWifiStopped() throws android.os.RemoteException;
  public void noteBluetoothOn() throws android.os.RemoteException;
  public void noteBluetoothOff() throws android.os.RemoteException;
  public void noteFullWifiLockAcquired(int uid) throws android.os.RemoteException;
  public void noteFullWifiLockReleased(int uid) throws android.os.RemoteException;
  public void noteScanWifiLockAcquired(int uid) throws android.os.RemoteException;
  public void noteScanWifiLockReleased(int uid) throws android.os.RemoteException;
  public void noteWifiMulticastEnabled(int uid) throws android.os.RemoteException;
  public void noteWifiMulticastDisabled(int uid) throws android.os.RemoteException;
  public void setOnBattery(boolean onBattery, int level) throws android.os.RemoteException;
  public void recordCurrentLevel(int level) throws android.os.RemoteException;
  /* Also got rid of the non-notification calls.
       * byte[] getStatistics();
       * long getAwakeTimeBattery();
       * long getAwakeTimePlugged();
       *//* Added functions to the normal IBatteryStats interface. */
  public void noteVideoOn(int uid) throws android.os.RemoteException;
  public void noteVideoOff(int uid) throws android.os.RemoteException;
  public void noteAudioOn(int uid) throws android.os.RemoteException;
  public void noteAudioOff(int uid) throws android.os.RemoteException;
}
