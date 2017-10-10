/**
 * Copyright (c) 2017-present, Facebook, Inc. All rights reserved.
 *
 * <p>This source code is licensed under the BSD-style license found in the LICENSE file in the root
 * directory of this source tree. An additional grant of patent rights can be found in the PATENTS
 * file in the same directory.
 */
package com.facebook.battery.reporter.camera;

import com.facebook.battery.metrics.camera.CameraMetrics;
import com.facebook.battery.reporter.api.SystemMetricsReporter;

public class CameraMetricsReporter implements SystemMetricsReporter<CameraMetrics> {

  public static final String CAMERA_OPEN_TIME_MS = "camera_open_time_ms";
  public static final String CAMERA_PREVIEW_TIME_MS = "camera_preview_time_ms";

  @Override
  public void reportTo(CameraMetrics metrics, SystemMetricsReporter.Event event) {
    // Do not report value if value is 0
    if (metrics.cameraOpenTimeMs != 0) {
      event.add(CAMERA_OPEN_TIME_MS, metrics.cameraOpenTimeMs);
    }
    if (metrics.cameraPreviewTimeMs != 0) {
      event.add(CAMERA_PREVIEW_TIME_MS, metrics.cameraPreviewTimeMs);
    }
  }
}