import React from 'react';
import {CONTENT_WIDTH, FONT, MARGIN} from "./styles/constants";

const ITEMS_PER_ROW = 5;
const CARD_MARGIN = MARGIN.small;

const TOTAL_MARGIN = (ITEMS_PER_ROW - 1) * 2 * CARD_MARGIN;
const CARD_WIDTH = (CONTENT_WIDTH - TOTAL_MARGIN) / ITEMS_PER_ROW;
const CARD_HEIGHT = CARD_WIDTH * 1.48;

const sectionStyle = {
    'padding-top': '20px',
};

const sectionTitleStyle = {
    ...FONT.subtitle,
};

const listStyle = {
    'list-style': 'none',
    'padding': '0',
    'display': 'flex',
    'margin': `-${CARD_MARGIN}px`,
};

const gridStyle = {
    ...listStyle,
    'flex-wrap': 'wrap',
};

const rowStyle = {
    ...listStyle,
};

const cardStyle = {
    'margin': `${CARD_MARGIN}px`,
    'width': `${CARD_WIDTH}px`,
    'height': `${CARD_HEIGHT}px`,
};

export function CardGrid(props) {
    return (
        <section style={sectionStyle}>
            <h2 style={sectionTitleStyle}>{props.title}</h2>
            <ol style={gridStyle} data-testid="filmList">
                {props.cards.map((card, index) => <li key={index} style={cardStyle}>{card}</li>)}
            </ol>
        </section>
    );
}

export function CardRow(props) {
    return (
        <section style={sectionStyle}>
            <h2 style={sectionTitleStyle}>{props.title}</h2>
            <ol style={rowStyle}>
                {props.cards.map((card, index) => <li key={index} style={cardStyle}>{card}</li>)}
            </ol>
        </section>
    );
}
