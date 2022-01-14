import * as React from 'react'
// import { useCallback } from 'react'
import { useState, useEffect } from 'react'

import { useKeycloak } from '@react-keycloak/web'

// import { useAxios } from '../utils/hooks'

const HomePage = () => {
  const { keycloak } = useKeycloak()
  const [routes, setRoutes] = useState([]);
  const [sites, setSites] = useState([]);


  // const axiosInstance = useAxios('http://localhost:5000') // see https://github.com/panz3r/jwt-checker-server for a quick implementation
  // const callApi = useCallback(() => {
  //   !!axiosInstance.current && axiosInstance.current.get('/jwt/decode')
  // }, [axiosInstance])

  useEffect(() => {
    console.log("authenticated");
    console.log(keycloak.resourceAccess);
    fetch("/sites", {
      headers: {
        Authorization: `Bearer ${keycloak.token}`,
      },
    }).then(response => {
      if (response.status === 401) {
        throw new Error(response.status)
      }
      return response.json()
    })
      .then(data => setSites(data)).catch((error) => {
        console.error('Error:', error);
      });

    fetch("/routes").then(response => response.json())
      .then(data => setRoutes(data)).catch((error) => {
        console.error('Error:', error);
      });

  }, [keycloak.authenticated])

  return (
    <div>
      <div>User is {!keycloak?.authenticated ? 'NOT ' : ''} authenticated</div>

      {!!keycloak?.authenticated && (
        <button type="button" onClick={() => keycloak.logout()}>
          Logout
        </button>
      )}

      {(sites.length > 0) && (<>
        <h3>Sites</h3>
        <ul>
          {sites.map((s, i) => <li key={i}>{s}</li>)}
        </ul>
      </>)
      }
      {(routes.length > 0) && (<>
        <h3>Routes</h3>
        <ul>
          {routes.map(r => <li key={r.id}>{r.title}</li>)}
        </ul>
      </>)
      }

      {/* <button type="button" onClick={callApi}>
        Call API
      </button> */}
    </div>
  )
}

export default HomePage