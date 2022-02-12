const findAnagrams = function (s, p) {
  const need = new Map();
  const win = new Map();
  const result = [];

  let left = 0, right = 0, validNum = 0;
  for (let c of p) {
    need.set(c,  need.has(c) ? need.get(c) + 1 : 1);
  }

  while (right < s.length) {
    const c = s[right];
    right++;

    if (need.has(c)) {
      win.set(c, win.has(c) ? win.get(c) + 1 : 1);
      if (need.get(c) === win.get(c)) {
        validNum++;
      }
    }

    while (right - left === p.length) {
      if (validNum === need.size) {
        result.push(left);
      }

      const d = s[left];
      left++;
      if (need.has(d)) {
        if (need.get(d) === win.get(d)) {
          validNum--;
        }
        win.set(d, win.get(d) - 1);
      }
    }
  }

  return result;
}
