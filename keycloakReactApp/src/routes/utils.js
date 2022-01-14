import * as React from 'react'
import { Navigate, Outlet  } from 'react-router-dom'
import { useKeycloak } from '@react-keycloak/web'


export function PrivateRoute() {
  const { keycloak } = useKeycloak()

  return (
        keycloak?.authenticated ? (
          <Outlet />
        ) : (
            <Navigate
            to='/login'/>
        )
  )
}