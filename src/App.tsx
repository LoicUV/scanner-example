import { Barcode, BarcodeScanner } from "@capacitor-mlkit/barcode-scanning";
import { FC, useState } from "react";

import './style.css';

const App: FC = () => {
    const [barcode, setBarcode] = useState<string>();
    const onClickBarcodeScan = async () => {
        try {
            const res = await new Promise<Barcode>(async (resolve) => {
                document.querySelector("body")?.classList.add("barcode-scanner-active");

                const listener = await BarcodeScanner.addListener("barcodeScanned", async (result) => {
                    await listener.remove();
                    document.querySelector("body")?.classList.remove("barcode-scanner-active");
                    await BarcodeScanner.stopScan();
                    resolve(result.barcode);
                });

                await BarcodeScanner.startScan();
            });

            setBarcode(res.rawValue);
        } catch (error) {
            console.error(error);
        }
    };
    return (
        <>
            <h1>Hello</h1>
            <button onClick={onClickBarcodeScan}>SCAN BARCODE</button>
            <p>scanned barcode : {barcode}</p>
        </>
    );
};

export default App;
