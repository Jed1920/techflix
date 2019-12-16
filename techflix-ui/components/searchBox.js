import React from 'react';
import {SearchIcon} from "./searchIcon";
import {COLORS, MARGIN} from "./styles/constants";

const searchBoxStyle = {
    'margin': '0',
    'padding': '0',
    'display': 'flex',
};

const visuallyHiddenStyle = {
    'position': 'absolute',
    'visibility': 'hidden',
};

const searchInputStyle = {
    'background': 'none',
    'border': 'none',
    'outline': 'none',
    'border-bottom': `${COLORS.foreground} 1px solid`,
    'font-size': '20px',
    'padding': '0',
    'color': COLORS.foreground,
    'transition': '0.2s ease all',
};

const submitButtonStyle = {
    'background': 'none',
    'border': 'none',
    'outline': 'none',
    'height': '100%',
    'margin': `0 0 0 ${MARGIN.small}px`,
    'padding': '0',
    'width': '40px',
};

export function SearchBox() {
    return (
        <form data-testid="searchBox" style={searchBoxStyle} action="http://localhost:3000/search" method="get">
            <label htmlFor="searchInput" style={visuallyHiddenStyle}>Search</label>
            <input id="searchInput" name="q" style={searchInputStyle} placeholder="Search"/>

            <button data-testid="searchButton" style={submitButtonStyle} type="submit"><SearchIcon/></button>
        </form>
    );
}