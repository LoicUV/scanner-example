import ReactDOM from "react-dom";

import App from "./App";

const render = (Component: React.ComponentType) => {
    ReactDOM.render(
        <Component />,
        document.getElementById("root") as HTMLElement
    );
};

render(App);
