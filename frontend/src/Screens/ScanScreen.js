import Scanner from "../components/Scanner";

function ScanScreen() {
    return (
        <div className="container pt-5">
            <div className="text-center align-items-center">
                <h1 className="mb-5">Scan a product</h1>
                <Scanner />
            </div>
        </div>
    );
}

export default ScanScreen;