import React from 'react';
import {COLORS, FONT} from "./styles/constants";
import {imageFillsParent} from "./styles/mixins";

const welcomeBannerStyle = {
    'height': '400px',
    'position': 'relative',
};

const imageStyle = {
    ...imageFillsParent()
};

const messageStyle = {
    'position': 'absolute',
    'max-width': '60%',
    'bottom': '20px',
    'left': '20px',
    'padding': '20px',
    'background': 'rgba(0,0,0,0.7)',
};

const titleStyle = {
    ...FONT.title,
};

const descriptionStyle = {
    ...FONT.body,
};

export function WelcomeBanner() {
    return (
        <section style={welcomeBannerStyle}>
            <img data-testid="welcomeImage" style={imageStyle} src="https://m.media-amazon.com/images/M/MV5BZmQ2YzJlZTUtZWYzMi00ZjJjLWJkMjEtYjU4NjRiNDU4ZTVmXkEyXkFqcGdeQXVyNjczOTE0MzM@._V1_.jpg"/>
            <div style={messageStyle} data-testid="welcomeText">
                <h1 style={titleStyle}>Star Wars: The Rise of Skywalker</h1>
                <p style={descriptionStyle}>The surviving Resistance faces the First Order once more in the final chapter of the Skywalker saga.</p>
            </div>
        </section>
    );
}