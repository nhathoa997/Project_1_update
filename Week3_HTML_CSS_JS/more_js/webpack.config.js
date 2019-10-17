const path = require('path');

module.exports = {
    entry: './src/index.js',
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname, 'dist')
    },
    watch: true,
    watchOptions: {
        aggregateTimeout: 300,
        poll: 500,
        ignored: /node_modules/
    },
    module: {
        rules: [
            {
                test: /\.(html|css)$/i,
                loader: 'file-loader',
                options: {
                    name: '[name].[ext]'
                }
            }
        ]
    }
};