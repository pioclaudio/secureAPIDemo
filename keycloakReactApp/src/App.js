import './App.css';
import { ReactKeycloakProvider  } from '@react-keycloak/web'
import keycloak from './keycloak'
import { AppRouter } from './routes';

function App() {
  return (
    <ReactKeycloakProvider authClient={keycloak}>
    <div className="App">
      <AppRouter />
    </div>
    </ReactKeycloakProvider>
  );
}

export default App;
