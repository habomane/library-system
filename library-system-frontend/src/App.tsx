import { RouterProvider, createBrowserRouter } from "react-router-dom";

// Components
import AppLayout from "./layout/AppLayout";
import PersonalLibraryPage from "./pages/PersonalLibrary";
import EditBookPage from "./pages/EditBook";
import CreateBookPage from "./pages/CreateBook";
import BookDetailsPage from "./pages/BookDetails";

export const routes = createBrowserRouter([
  {
    element: <AppLayout />,
    children: [
      { path: "/", element: <PersonalLibraryPage /> },
      { path: "/templates", element: <EditBookPage /> },
      { path: "/template/:id", element: <CreateBookPage /> },
      { path: "/template/create", element: <BookDetailsPage /> },
    ],
  },
]);

function App() {

  return <RouterProvider router={routes} />;
}

export default App
