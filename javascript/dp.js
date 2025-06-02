const fib = (n) => {
    const table = Array(n + 1).fill(0);
    table[1] = 1;

    for( i= 0; i <= n; i++) {
        table[i + 1] += table[i];
        table[i + 2] += table[i];
    }

    return table[n]
};

const countConstruct = (target, wordbank) => {
    const table = Array(target.length + 1).fill(0);
    table[0] = 1

    for( let i= 0; i <= target.length; i++) {
        if( table[i] != 0) {
            for ( let word of wordbank) {
                if ( (i + word.length) <= target.length && target.slice(i, i + word.length) === word) {
                    table[i + word.length] += table[i];
                }
            }
        }
    }

    return table[target.length]
};

console.log(fib(10))