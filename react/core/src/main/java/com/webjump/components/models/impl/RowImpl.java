package com.airgroup.corecomponents.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ContainerExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.airgroup.corecomponents.core.models.Row;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import java.util.Map;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.via.ResourceSuperType;
import org.apache.sling.models.annotations.injectorspecific.Self;
import com.adobe.cq.wcm.core.components.models.LayoutContainer;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
    Row.class,
    ComponentExporter.class,
    ContainerExporter.class
}, resourceType = RowImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL) 
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class RowImpl implements Row {

    static final String RESOURCE_TYPE = "corecomponents/components/row";

		@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String padding;

		@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String width;

		@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String height;

		@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String margin;

		@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String gap;

		@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String strecth;

		@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String justify;

		@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String align;

		@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String flexDirection;
		
		@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String childWidth;

		@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String childAlign;

		@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String childJustify;

		@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
		private Boolean shouldBeColumn;

    @Self
    @Via(type = ResourceSuperType.class)
    private LayoutContainer layoutContainer;

    @SlingObject
    private Resource resource;

		@Override

    public String getPadding() {
        return padding;
    }

		@Override
    public String getWidth() {
        return width;
    }

		@Override
    public String getHeight() {
        return height;
    }
		
		@Override
    public String getMargin() {
        return margin;
    }

		@Override
    public String getGap() {
        return gap;
    }

		@Override
    public String getStrecth() {
        return strecth;
    }

		@Override
    public String getJustify() {
        return justify;
    }

		@Override
    public String getAlign() {
        return align;
    }

		@Override
    public String getFlexDirection() {
        return flexDirection;
    }

		@Override
    public String getChildWidth() {
        return childWidth;
    }

		@Override
    public String getChildAlign() {
        return childAlign;
    }

		@Override
    public String getChildJustify() {
        return childJustify;
    }

		@Override
    public Boolean getShouldBeColumn(){
			return shouldBeColumn;
		}

    @Override
    public Map<String, ? extends ComponentExporter> getExportedItems() {
        return layoutContainer.getExportedItems();
    }

    @Override
    public String[] getExportedItemsOrder() {
        return layoutContainer.getExportedItemsOrder();
    }

    @Override
    public String getExportedType() {
        return RowImpl.RESOURCE_TYPE;
    }
}
