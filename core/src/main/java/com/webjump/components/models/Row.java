
package com.airgroup.corecomponents.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import org.osgi.annotation.versioning.ConsumerType;
import com.adobe.cq.export.json.ContainerExporter;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Defines the {@code Row} Sling Model used for the {@code corecomponents/components/row} component.
 * 
 */
@ConsumerType
public interface Row extends ContainerExporter
{
    String getPadding();

    String getWidth();

    String getHeight();

    String getMargin();

    String getGap();

    String getStrecth();

    String getJustify();

    String getAlign();

    String getFlexDirection();

    String getChildWidth();

    String getChildAlign();

    String getChildJustify();

    Boolean getShouldBeColumn();
}
