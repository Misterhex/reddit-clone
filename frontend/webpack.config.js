const webpack = require('webpack');
const ExtractTextPlugin = require("extract-text-webpack-plugin");
const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
	entry: './index.jsx',
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
				use: ExtractTextPlugin.extract({
					fallback: "style-loader",
					use: "css-loader"
				})
			}, {
				test: /\.(png|woff|woff2|eot|ttf|svg)$/, loader: 'url-loader?limit=100000'
			}, {
				test: /\.jsx$/,
				exclude: /node_modules/,
				loaders: ["babel-loader"],
			}
		]
	},
	plugins: [new HtmlWebpackPlugin({
		template: "./index.html"
	}),
	new ExtractTextPlugin("styles.css"),
	new webpack.ProvidePlugin({
		$: 'jquery',
		jQuery: 'jquery'
	})
	],
	devServer: {
		contentBase: path.join(__dirname, "dist"),
		compress: true,
		port: 9000,
		inline: true
	},
	devtool: 'source-map'
};
