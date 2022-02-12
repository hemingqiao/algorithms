function solution() {
  let input = readline();
  let coords = input.split(";");
  let x0 = 0, y0 = 0;
  coords = coords.filter(c => /^[ADWS]\d{1,2}$/.test(c));
  coords.forEach(c => {
    let dir = c[0];
    let num = Number(c.slice(1));
    switch (dir) {
      case "A":
        x0 -= num;
        break;
      case "D":
        x0 += num;
        break;
      case "W":
        y0 += num;
        break;
      case "S":
        y0 -= num;
        break;
    }
  });
  console.log(x0 + "," + y0);
}

solution();
