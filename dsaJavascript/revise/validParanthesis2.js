function isValid(s) {
     parenthesis = {
        "{": "}",
        "(": ")",
        "[": "]"
    }
    
    let stack = []
    for (let v of s) {
        if (parenthesis[v]) {
             stack.push(v)
        } else {
            let p = stack.pop()
            if (parenthesis[p] !== v) return false;
        }
    }
    return stack.length === 0
};
