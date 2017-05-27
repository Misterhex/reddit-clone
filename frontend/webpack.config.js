var path = require('path');
var HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
	entry: './index.js',
	output: {
		filename: 'bundle.[hash].js',
		path: path.resolve(__dirname, 'dist')
	},
	module: {
		rules: [
			{
				test: /\.html$/,
				use: 'html-loader'
			}, {
				test: /\.css$/,
				use: ['style-loader', 'css-loader']
			}, {
				test: /\.(png|woff|woff2|eot|ttf|svg)$/, loader: 'url-loader?limit=100000'
			}]
	},
	plugins: [new HtmlWebpackPlugin({
		template: "./index.html"
	})]
};
