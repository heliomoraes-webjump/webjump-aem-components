// webpack.config.js

const path = require('path');

module.exports = {
  mode: 'production', // ou 'development' dependendo da sua fase de desenvolvimento
  entry: './src/index.js', // ou './src/index.ts' se estiver usando TypeScript
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'index.js',
    library: '@webjump/aem-components',
    libraryTarget: 'umd', // Universal Module Definition, para suportar CommonJS, AMD e exportação global
    globalObject: 'this',
  },
  resolve: {
    extensions: ['.js', '.jsx', '.ts', '.tsx'], // Adicione as extensões que deseja resolver
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx|ts|tsx)$/,
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: [
              '@babel/preset-env',
              '@babel/preset-react',
              '@babel/preset-typescript' // Adicione este preset se estiver usando TypeScript
            ]
          }
        }
      },
      {
        test: /\.css$/, // Caso você tenha estilos CSS
        use: ['style-loader', 'css-loader']
      },
    ],
  },
  externals: {
    react: 'React', // Não inclua o React na bundle
    'react-dom': 'ReactDOM', // Não inclua o ReactDOM na bundle
  },
};
