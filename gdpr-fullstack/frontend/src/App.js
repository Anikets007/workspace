import React, {useState} from 'react';
import Login from './components/Login';
import CustomerList from './components/CustomerList';

function App(){
  const [token, setToken] = useState(null);
  return (
    <div style={{padding:20}}>
      <h1>GDPR Customer Manager</h1>
      {!token ? <Login onLogin={setToken}/> : <CustomerList token={token} />}
    </div>
  );
}

export default App;
