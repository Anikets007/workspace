const BASE = process.env.REACT_APP_API || 'http://localhost:8080/api';

export async function login(username, password) {
  const res = await fetch('http://localhost:8080/auth/login', {
    method: 'POST',
    headers: {'Content-Type':'application/json'},
    body: JSON.stringify({username, password})
  });
  return res.json();
}

export async function fetchCustomers(token) {
  const res = await fetch(`${BASE}/customers`, { headers: { Authorization: `Bearer ${token}` } });
  return res.json();
}

export async function requestDeletion(id, token) {
  const res = await fetch(`${BASE}/customers/${id}/request-deletion`, { method: 'POST', headers: { Authorization: `Bearer ${token}` } });
  return res;
}
