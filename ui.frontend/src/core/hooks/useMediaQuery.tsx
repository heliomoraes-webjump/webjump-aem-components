import { useEffect, useState } from 'react';
const useMediaQuery = (mediaQuery: string): boolean => {
	const [match, setMatch] = useState(
		Boolean(window.matchMedia(mediaQuery).matches)
	);
	useEffect(() => {
		const mediaQueryList = window.matchMedia(mediaQuery);
		const handler = () => setMatch(Boolean(mediaQueryList.matches));
		mediaQueryList.addEventListener('change', handler);
		handler();
		return () => mediaQueryList.removeEventListener('change', handler);
	}, [mediaQuery]);
	return match;
};
export default useMediaQuery;
