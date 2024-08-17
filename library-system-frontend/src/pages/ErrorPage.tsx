import { useRouteError } from "react-router-dom";
import { useEffect, useState } from "react";

function ErrorBoundary() {
    const error = useRouteError();
    const [errorMessage, setErrorMessage] = useState("");
    useEffect(() => {
        if (error !== null) {setErrorMessage(error.data.replace("Error:", ""))}
        else { setErrorMessage("Internal Server Error") }
    })

    return (
        <main className="flex flex-col justify-center items-center h-[100vh]">
        <h1 className="text-3xl font-bold text-red-800">Error{": " + error.status}</h1>
        <div>{errorMessage}</div>

        </main>  )
  }

  export default ErrorBoundary;