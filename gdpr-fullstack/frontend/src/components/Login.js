import React, {useState} from 'react';
import {login} from '../services/api';

export default function Login({onLogin}) {
  const [username,setUsername]=useState('');
  const [password,setPassword]=useState('');
  const [err,setErr]=useState(null);

  async function submit(e){
    e.preventDefault();
    const res = await login(username,password);
    if (res && res.token) {
      onLogin(res.token);
    } else {
      setErr(res.error || 'Login failed');
    }
  }

  return (
    <form onSubmit={submit}>
      <div><input placeholder="username" value={username} onChange={e=>setUsername(e.target.value)} /></div>
      <div><input type="password" placeholder="password" value={password} onChange={e=>setPassword(e.target.value)} /></div>
      <button type="submit">Login</button>
      {err && <div style={{color:'red'}}>{err}</div>}
    </form>
  );
}
