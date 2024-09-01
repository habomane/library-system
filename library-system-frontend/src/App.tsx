import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { createContext, useState, useEffect } from "react";
import { User } from "./models";
import { getUserDetails, userDetailsExist } from "./helper/user";
// Components
import AppLayout from "./layout/AppLayout";
import HomePage from "./pages/HomePage";
import DiscoverPage from "./pages/DiscoverPage";
import LibraryPage from "./pages/LibraryPage";
import EditBookPage from "./pages/EditBook";
import CreateBookPage from "./pages/CreateBook";
import BookDetailsPage from "./pages/BookDetails";
import AccountDetailsPage from "./pages/AccountDetailsPage";
import ErrorBoundary from "./pages/ErrorPage";
import SignUpPage from "./pages/SignupPage";
import LoginPage from "./pages/LoginPage";
import BookRequestPage from "./pages/BookRequestPage";

export const UserContext = createContext<[User, React.Dispatch<React.SetStateAction<User>>] | null>(null);

const routes = createBrowserRouter([
  {
    element: <AppLayout />,
    children: [
      { path: "/", element: <HomePage /> },
      { path: "/discover", element: <DiscoverPage /> },
      { path: "/library", element: <LibraryPage /> },
      { path: "/edit/:id", element: <EditBookPage /> },
      { path: "/create", element: <CreateBookPage /> },
      { path: "/details/:id", element: <BookDetailsPage /> },
      { path: "/account/:id", element: <AccountDetailsPage /> },
      { path: "/signup", element: <SignUpPage /> },
      { path: "/login", element: <LoginPage /> },
      { path: "/request/", element: <BookRequestPage /> }
    ],
    errorElement: <ErrorBoundary />,
  },
]);

function App() {
  const [user, setUser] = useState(new User("", "", "", "", ""));

  useEffect(() => {
    if (userDetailsExist()) {
      setUser(getUserDetails());
    }
  }, []);

  return (
    <UserContext.Provider value={[user, setUser]}>
      <RouterProvider router={routes} />
    </UserContext.Provider>
  );
}

export default App;
