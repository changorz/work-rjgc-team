module.exports = {
  devServer: {
    port: 80,
    disableHostCheck: true,
    proxy: {
      // 强智科技代理
      '/znlykjdxswxy': {
        target: 'http://zswxyjw.minghuaetc.com',
        pathRewrite: {
          '^/znlykjdxswxy': 'znlykjdxswxy'
        }
      }
    }/*,
    configureWebpack: {
      plugins: [
        // eslint-disable-next-line no-undef
        new webpack.ProvidePlugin({
          $: 'jquery',
          jQuery: 'jquery',
          'windows.jQuery': 'jquery'
        })
      ]
    },
    lintOnSave: undefined */
  }
}
