import React from 'react';
import {COLORS, DEFAULT_FONT} from "../styles/constants";

const logoStyles = {
    'height': '100%',
    'background': COLORS.background
};

const fontStyles = {
    'font-family': DEFAULT_FONT,
    'fill': COLORS.primary,
    'stroke-width': '0',
    'font-size': '122px'
};

const ellipseStyle = {
    'fill': COLORS.background,
};

export function Logo() {
    return (
        <svg viewBox="0 0 580 140" style={logoStyles}>
            <text style={fontStyles} transform="matrix(1.2993086576461792,0,0,1.283022255168109,0.748271644115448,-23.77847251153735) " textAnchor="start" y="117.04375" x="1.26964" >T</text>
            <text style={fontStyles} transform="matrix(1.1308794021606445,0,0,1.277586921688814,-74.81393826007843,-37.062227826942966) " textAnchor="start" y="126.624571" x="506.96293" >X</text>
            <text style={fontStyles} transform="matrix(1.1530002355575562,0,0,1.0539788593345476,-13.081520140171051,0.6338038862836562) " textAnchor="start" y="100.355746" x="88.101908" >E</text>
            <text style={fontStyles} transform="matrix(1.1530002355575562,0,0,1.1355942963991408,-13.081520140171051,2.1974353749359246) " textAnchor="start" y="98.411636" x="408.136534" >I</text>
            <text style={fontStyles} transform="matrix(1.1530002355575562,0,0,0.9049872619041249,-13.081520140171051,-1.4250848645710612) " textAnchor="start" y="104.216033" x="151.414991" >C</text>
            <text style={fontStyles} transform="matrix(1.1530002355575562,0,0,1.0201234623965676,-13.081520140171051,0.09531562066645638) " textAnchor="start" y="100.321161" x="350.027266" >L</text>
            <text style={fontStyles} transform="matrix(1.1530002355575562,0,0,0.911527038457353,-13.081520140171051,-1.644270820815989) " textAnchor="start" y="103.482948" x="217.329982" >H</text>
            <text style={fontStyles} transform="matrix(1.1530002355575562,0,0,0.8915252936192605,-13.081520140171051,-1.8467688870862111) " textAnchor="start" y="104.489975" x="287.581485" >F</text>
            <ellipse style={ellipseStyle} ry="66.500001" rx="325.50001" cy="155.543746" cx="289.00001" strokeWidth="0"/>
        </svg>
    );
}