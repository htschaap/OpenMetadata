package org.openmetadata.service.search.indexes;

import java.util.Map;
import org.openmetadata.schema.analytics.ReportData;

public record ReportDataIndexes(ReportData reportData) implements SearchIndex {

  @Override
  public Object getEntity() {
    return reportData;
  }

  @Override
  public Map<String, Object> buildSearchIndexDocInternal(Map<String, Object> doc) {
    doc.put("id", null);
    doc.put("timestamp", reportData.getTimestamp());
    doc.put("reportDataType", reportData.getReportDataType());
    doc.put("data", reportData.getData());
    return doc;
  }
}
