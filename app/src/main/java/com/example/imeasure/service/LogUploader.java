package com.example.imeasure.service;

import android.content.Context;

public class LogUploader {
  public LogUploader(Context context) {
  }

  /* Returns true if this module supports uploading logs. */
  public static boolean uploadSupported() {
    return false;
  }

  /* Returns true if the log should be uploaded now.  This may depend on log
   * file size, network conditions, etc. */
  // TODO: This should probably give the file name of the log
  public boolean shouldUpload() {
    return false;
  }

  /* Called when the device is plugged in or unplugged.  The intended use of
   * this is to improve upload policy decisions. */
  public void plug(boolean plugged) {
  }

  /* Initiate the upload of the file with the passed location. */
  public void upload(String origFile) {
  }

  /* Returns true if a file is currently being uploaded. */
  public boolean isUploading() {
    return false;
  }

  /* Interrupt any threads doing upload work. */
  public void interrupt() {
  }

  /* Join any threads that may be performing log upload work. */
  public void join() throws InterruptedException {
  }
}
