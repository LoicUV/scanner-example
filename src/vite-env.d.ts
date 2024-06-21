/// <reference types="vite/client" />

interface ImportMetaEnv {
    readonly VITE_API_BASE_URL: string | undefined;
    readonly VITE_API_KEY: string | undefined;
    readonly VITE_GOOGLE_ANALYTICS: string | undefined;
    readonly VITE_VERSION: string;
    readonly VITE_FACEBOOK_APP_ID: string | undefined;
}

interface ImportMeta {
    readonly env: ImportMetaEnv;
}

import "@types/facebook-js-sdk";
