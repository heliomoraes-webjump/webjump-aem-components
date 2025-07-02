import React, { CSSProperties } from 'react';
import {
	MapTo,
	AllowedComponentsContainer,
	AllowedComponentsProperties,
	withComponentMappingContext,
} from '@adobe/aem-react-editable-components';

import useMediaQuery from '../../hooks/useMediaQuery';

type RowProps = AllowedComponentsProperties & {
	padding?: CSSProperties['padding'];
	height?: CSSProperties['height'];
	margin?: CSSProperties['margin'];
	gap?: CSSProperties['gap'];
	stretch?: CSSProperties['flexGrow'];
	justify?: CSSProperties['justifyContent'];
	align?: CSSProperties['alignItems'];
	flexDirection?: CSSProperties['flexDirection'];
	width?: CSSProperties['width'];
	childWidth?: CSSProperties['width'];
	childJustify?: CSSProperties['justifyContent'];
	childAlign?: CSSProperties['alignItems'];
	shouldBeColumn?: boolean;
};

const RowConfig = {
	emptyLabel: 'Row',
	isEmpty: (props: AllowedComponentsProperties) => !props,
};

const Row: React.FC<RowProps> = ({ ...props }) => {
	const isMobile = useMediaQuery('(max-width: 768px)');

	const { childComponents, placeholderComponent } =
		new AllowedComponentsContainer(props);

	const containerStyles: CSSProperties = {
		display: 'flex',
		flexWrap: 'wrap',
		padding: props.padding,
		height: props.height,
		margin: props.margin,
		gap: props.gap,
		flexGrow: props.stretch,
		justifyContent: props.justify,
		alignItems: props.align,
		flexDirection:
			props.shouldBeColumn || isMobile ? 'column' : props.flexDirection,
		width: props.width,
	};

	const innerContainerStyles: CSSProperties = {
		display: 'flex',
		width: props.childWidth,
		alignItems: props.childAlign,
		justifyContent: props.childJustify,
	};

	return (
		<div style={containerStyles}>
			{childComponents?.map((component, index) => (
				<div key={index} style={innerContainerStyles}>
					{component}
				</div>
			))}
			{placeholderComponent}
		</div>
	);
};

MapTo('webjump/components/row')(
	withComponentMappingContext(Row),
	RowConfig
);

export default Row;
