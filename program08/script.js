document.getElementById("generate").addEventListener("click", () => {
  const getvalue = (id) => parseInt(document.getElementById(id).value);

  const p = getvalue("p");
  const g = getvalue("g");
  const A = getvalue("A");
  const B = getvalue("B");

  const calc = (base, exponent, mod) => Math.pow(base, exponent) % mod;

  // calculate public key of A:
  const a = calc(g, A, p);
  const b = calc(g, B, p);

  // calculate shared secret key:
  const ka = calc(b, A, p);
  const kb = calc(a, B, p);

  const res = `
    <p>Alice Public key: ${a} </p>
    <p>Bob public key: ${b} </p>
    <p>Shared key 1: ${ka} </p>
    <p> Shared key 2: ${kb} </p>
    `;
  document.getElementById("op").innerHTML = res;
});